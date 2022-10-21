import React from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const Kakao = (props) => {
    const navigate = useNavigate();

    const href = window.location.href;
    let params = new URL(href).searchParams;
    let code = params.get('code');

    React.useEffect(() => {
        if (localStorage.getItem('email') === null) {
            localStorage.setItem('email', '');
            axios.get(`http://localhost:8000/api/v1/login?code=${code}`).then(
                (result) => {
                    sessionStorage.setItem('token', result.data.token);
                    localStorage.setItem('email', result.data.email);
                    localStorage.setItem('nickname', result.data.nickname);
                    const nickname = localStorage.getItem('nickname');
                    alert(`${nickname}님 무신사에 오신것을 환영해요!`);
                    navigate('/');
                },
                (error) => {
                    console.error(error);
                    alert('로그인에 실패했어요 😢');
                    navigate('/');
                }
            );
        }
    }, []);

    return (
        <>
            <h3 style={{ color: 'white' }}>
                <p>잠시만 기다려 주세요.</p>
                <p>로그인 중입니다.</p>
            </h3>
        </>
    );
};

export default Kakao;
