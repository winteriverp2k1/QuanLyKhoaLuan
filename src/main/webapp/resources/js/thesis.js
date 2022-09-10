/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


document.addEventListener("DOMContentLoaded", () => {
        document.getElementById("choose").addEventListener("change", function (e) {
            fetch(`/QuanLyKhoaLuan/admin/userManager/users/?roleName=${e.target.value}`, {
                            method: "GET",
                            headers: {
                                "Content-Type": "application/json",
                            },
                        }).then(res => res.json()).then(data => {
                            let users = document.getElementById("userId")
                            let test = ""
                            console.log(data)
                            for (let i = 0; i < data.length; i++) {
                                let id = data[i].id.toString();
                                let fullname = data[i].fullname.toString();
                                console.log(`<option value="id">fullname</option>`);
                                console.log(id, fullname)
                                test += `<option value=${id}}>${fullname}</option>`;
                            }
                            users.innerHTML = test;
                        }).catch(err => {
                            console.log(err);
                        })
                    });
                });


