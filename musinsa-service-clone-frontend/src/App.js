import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Header from './components/Header';
import Main from './components/Main';
import NotFound from './components/NotFound';
import Kakao from './components/Kakao';

function App() {
    return (
        <div className="container-fluid">
            <BrowserRouter>
                <Header />
                <Routes>
                    <Route path="/" element={<Main />}></Route>
                    <Route path="*" element={<NotFound />}></Route>
                    <Route path="/oauth2/kakao" element={<Kakao />}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
