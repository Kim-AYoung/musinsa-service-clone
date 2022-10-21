import React from 'react';

export function Product(props) {
    const productId = props.id;
    const productName = props.name;
    const category = props.category;
    const price = props.price;
    const description = props.description;

    const handleAddBtnClicked = (e) => {
        props.onAddClick(productId);
    };

    return (
        <>
            <div className="col">
                <div className="row text-muted">{productName}</div>
                <div className="row">{category}</div>
            </div>
            <div className="col text-center price">{price}원</div>
            <div className="col text-end action">
                <button
                    onClick={handleAddBtnClicked}
                    className="btn btn-small btn-outline-dark"
                >
                    추가
                </button>
            </div>
        </>
    );
}
