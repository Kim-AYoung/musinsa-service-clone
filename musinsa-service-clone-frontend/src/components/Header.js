import React from 'react';
import { Link } from 'react-router-dom';

function Header(props) {
    return (
        <>
            <Link to="/" style={{ textDecoration: 'none', color: 'white' }}>
                <div className="row justify-content-center m-4">
                    <h1 className="text-center">MUSINSA STORE</h1>
                </div>
            </Link>
        </>
    );
}

export default Header;
