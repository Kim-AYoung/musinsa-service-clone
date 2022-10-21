import React from 'react';
import { Link } from 'react-router-dom';

const NotFound = () => {
    return (
        <>
            <div className="row justify-content-center m-4">
                <h2 className="text-center" style={{ color: 'red' }}>
                    404 Error
                </h2>
            </div>
            <Link to="/">
                <div className="row justify-content-center m-4">
                    <p className="text-center">Back</p>
                </div>
            </Link>
        </>
    );
};

export default NotFound;
