import './App.css';
import Navbar from './components/Navbar.js';
import AddEmp from './components/AddEmp.jsx';
import {Routes, Route} from 'react-router-dom';
import Home from './components/Home.jsx';
import EditEmp from './components/EditEmp';

function App() {
  return (

    <div >
      
      <Navbar></Navbar>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/addEmp" element={<AddEmp/>}></Route>
        <Route path="/editEmp/:id" element={<EditEmp />}></Route>
      </Routes>
      </div>
  );
}

export default App;
