import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react'
import empService from '../service/emp.service';
import {Link} from "react-router-dom";

const Home = () => {

    //using hook here
    const [empList, setEmpList] = useState([]);

    //for printing the message
    const [msg, setMsg]=useState("");

    useEffect(()=>{
      init();
    }, []);


    const init=()=>{
      empService
      .getAllEmp()
      .then((res) => {
        //for printing the data in console. it will print the all data from sql
        console.log(res.data);
        setEmpList(res.data);
      })
      .catch((error) => {
        console.log(error);
      })
    }



    const deleteEmp=(id)=>{
      empService.deleteEmp(id).then((res)=>{
          setMsg("Deleted Successfully...!")
          init();
      })
      .catch((error)=>{
        console.log(error);
      })
    }
    



  return (
    <div className='container'>
        <h1 className="text-center md-2">Employee Management System</h1>
{
  msg && <p className='text-center text-success'>{msg}</p>
}
        <table class="table">
        <thead>
            <tr>
            <th scope="col">Emp ID</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Salary</th>
            <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
          {empList.map((e, num) => (
              <tr>
              <th scope="row">{num+1}</th>
              <td>{e.firstName}</td>
              <td>{e.lastName}</td>
              <td>{e.email}</td>
              <td>{e.address}</td>
              <td>{e.salary}</td>
              <td>

                <Link to={"editEmp/"+e.id} className='btn btn-sm btn-primary'>Edit</Link>
                <a onClick={()=>deleteEmp(e.id)} className='btn btn-sm btn-danger ms-2'>Delete</a>

              </td>
              
              </tr>
          
          ))}
            
        </tbody>
        </table>


    </div>


    
    
  )
}

export default Home