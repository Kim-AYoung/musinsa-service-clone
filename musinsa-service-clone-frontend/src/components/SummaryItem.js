import React from 'react';

export function SummaryItem({ productName, count }) {
    return (
        <div className="row m-2">
            <h6 className="p-0">
                <span>{productName} </span>
                <span className="badge bg-dark text-">{count}개</span>
            </h6>
        </div>
    );
}
