const url = "http://localhost:3002"

document.getElementById("loginButton").onclick = loginFunction;
var userData = null;







async function loginFunction() {

    let user = document.getElementById("username").value
    let pass = document.getElementById("password").value

    let userCreds = {
        username: user,
        password: pass
    }

    console.log(userCreds)

    let response = await fetch(url + "/login",{
        method: "POST",
        body: JSON.stringify(userCreds),
        credentials: "include"
    })

    console.log(response.status)

    if(response.status === 202){

        userData = await response.json()

        store()

        if(userData.role_id_fk === 1 || userData.role_id_fk === 2){
            
        document.getElementById("loginRow").innerText = "Welcome back " + userData.first_name
        location.href="http://127.0.0.1:5500/HTML/apartmentcomManager.html";

        }else{
            document.getElementById("loginRow").innerText = "Welcome back " + userData.first_name
            window.location.href = "http://127.0.0.1:5500/HTML/apartmentcomEmp.html"
        }

    }else{
        document.getElementById("loginHeader").innerText = "Login Failed"
        document.getElementById("loginHeader").style.color = "red"
    }
}

function store(){
          var userID = userData.user_id;
          var user_name = userData.username;
          var firstname = userData.first_name;
          var lastname = userData.last_name;
          var emailaddress = userData.email;
          var roleId = userData.role_id_fk;
      
          sessionStorage.setItem("userID",userID)
          sessionStorage.setItem("user_name",user_name)
          sessionStorage.setItem("firstname",firstname)
          sessionStorage.setItem("lastname",lastname)
          sessionStorage.setItem("emailaddress",emailaddress)
          sessionStorage.setItem("roleId",roleId)
}