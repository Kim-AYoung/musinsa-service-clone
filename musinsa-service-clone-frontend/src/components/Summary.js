import React from 'react';
import { SummaryItem } from './SummaryItem';
import { useState } from 'react';

export function Summary({ items = [], onOrderSubmit }) {
    const totalPrice = items.reduce(
        (prev, curr) => prev + curr.price * curr.count,
        0
    );
    const [order, setOrder] = useState({
        address: '',
    });
    const handleAddressInputChanged = (e) =>
        setOrder({
            ...order,
            address: e.target.value,
        });

    const handleSubmit = (e) => {
        if (order.address === '') {
            alert('입력값을 확인해주세요!');
        } else {
            onOrderSubmit(order);
        }
    };

    return (
        <React.Fragment>
            <div>
                <h5 className="m-0 p-0">
                    <b>장바구니</b>
                </h5>
            </div>
            <hr />
            {items.map((v) => (
                <SummaryItem key={v.id} productName={v.name} count={v.count} />
            ))}
            <div>
                <h5 className="m-0 p-0">
                    <b>주문 정보</b>
                </h5>
            </div>
            <hr />
            <form>
                <div className="mb-3">
                    <label htmlFor="address" className="form-label">
                        주소
                    </label>
                    <input
                        type="text"
                        className="form-control mb-1"
                        id="address"
                        value={order.address}
                        onChange={handleAddressInputChanged}
                    />
                </div>
                <div>당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.</div>
            </form>
            <div className="row pt-2 pb-2 border-top">
                <h5 className="col">총금액</h5>
                <h5 className="col text-end">{totalPrice}원</h5>
            </div>
            <button
                className="btn btn-dark col-12"
                color="#0A174E"
                onClick={handleSubmit}
            >
                결제하기
            </button>
        </React.Fragment>
    );
}
