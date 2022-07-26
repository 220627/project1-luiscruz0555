const url = "http://localhost:3002"

document.getElementById("loginButton").onclick = loginFunction;




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

        let userData = await response.json()
        document.getElementById("loginRow").innerText = "Welcome back " + userData.first_name

    }else{
        document.getElementById("loginHeader").innerText = "Login Failed"
        document.getElementById("loginHeader").style.color = "red"
    }
}