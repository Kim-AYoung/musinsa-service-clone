import React, { useEffect, useState } from 'react';

import './Main.css';
import 'bootstrap/dist/css/bootstrap.css';
import { useNavigate } from 'react-router-dom';

import { ProductList } from './ProductList';
import { Summary } from './Summary';
import axios from 'axios';

import kakaoLoginLogo from '../assets/kakao_login_medium_narrow.png';

const Main = (props) => {
    const navigate = useNavigate();

    const [products, setProducts] = useState([]);

    const [items, setItems] = useState([]);

    const handleAddBtnClicked = (productId) => {
        const product = products.find((v) => v.id === productId);
        const found = items.find((v) => v.id === productId);
        const updatedItems = found
            ? items.map((v) =>
                  v.id === productId ? { ...v, count: v.count + 1 } : v
              )
            : [...items, { ...product, count: 1 }];

        setItems(updatedItems);
        console.log(product, 'added!');
    };

    useEffect(() => {
        axios
            .get('http://localhost:8000/api/v1/products')
            .then((v) => setProducts(v.data));
    }, []);

    const handleOrderSubmit = (order) => {
        if (items.length === 0) {
            alert('아이템을 추가해 주세요!');
        } else {
            axios
                .post('http://localhost:8000/api/v1/order', {
                    address: order.address,
                    createOrderProductRequestDtos: items.map((v) => ({
                        productId: v.id,
                        quantity: v.count,
                    })),
                })
                .then(
                    (v) => alert('주문이 정상적으로 접수되었어요.'),
                    (e) => {
                        alert('서버 장애가 발생했어요 😢');
                        console.error(e);
                    }
                );
        }
        console.log(order, items);
    };

    const handleLogout = (e) => {
        sessionStorage.clear();
        localStorage.clear();
        alert(`안녕히 가세요.`);
        navigate('/');
    };

    const REST_API_KEY = process.env.REACT_APP_REST_API_KEY;
    const REDIRECT_URI = 'http://localhost:3000/oauth2/kakao';
    const KAKAO_AUTH_URI = `https://kauth.kakao.com/oauth/authorize?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code`;

    let loginBtn;
    if (localStorage.getItem('email') === null) {
        loginBtn = (
            <span>
                <a href={KAKAO_AUTH_URI}>
                    <img
                        alt="Kakao Login Logo"
                        style={{
                            width: `${(1 / 12) * 100}%`,
                            height: '30px',
                        }}
                        src={kakaoLoginLogo}
                    />
                </a>
            </span>
        );
    } else {
        const nickname = localStorage.getItem('nickname');
        loginBtn = (
            <>
                <h3 style={{ color: 'white' }}>{nickname}님</h3>
                <span>
                    <button
                        className="btn btn-danger col-1"
                        onClick={handleLogout}
                    >
                        로그아웃
                    </button>
                </span>
            </>
        );
    }

    return (
        <>
            <div className="row p-3">{loginBtn}</div>
            <div className="card">
                <div className="row">
                    <div className="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
                        <ProductList
                            products={products}
                            onAddClick={handleAddBtnClicked}
                        />
                    </div>
                    <div className="col-md-4 summary p-4">
                        <Summary
                            items={items}
                            onOrderSubmit={handleOrderSubmit}
                        />
                    </div>
                </div>
            </div>
        </>
    );
};

export default Main;
