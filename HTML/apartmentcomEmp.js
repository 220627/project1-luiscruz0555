const url = "http://localhost:3002"

document.getElementById("getMyReimbs").onclick = getEmpReimbs
document.getElementById("createReimb").onclick = createReimb
document.getElementById("logout").onclick = logout


var data = null;

var userID = null
var user_name = null
var firstname = "test"
var lastname = null
var emailaddress = null
var roleID = null

function get(){
    userID = sessionStorage.getItem("userID")
    user_name = sessionStorage.getItem("user_name")
    firstname = sessionStorage.getItem("firstname")
    console.log(firstname)
    lastname = sessionStorage.getItem("lastname")
    emailaddress = sessionStorage.getItem("emailaddress")
    roleID = sessionStorage.getItem("roleID")
}

async function getEmpReimbs() {

    get()

    while(document.getElementById("reimbBody").rows.length>0){
        document.getElementById("reimbBody").deleteRow(0);
    }

    let response = await fetch(url + "/getMyReimbs",{
        method: "POST",
        body: userID
    })

    console.log(response.status)

    if(response.status === 200){
        data = await response.json()

        console.log(data)

        for(let reimb of data){
            let row = document.createElement("tr")
            let cell = document.createElement("td")
            cell.innerHTML = reimb.reimb_id
            row.appendChild(cell)
            let cell2 = document.createElement("td")
            cell2.innerHTML = reimb.reimb_amount
            row.appendChild(cell2)
            let cell3 = document.createElement("td")
            cell3.innerHTML = reimb.reimb_submitted
            row.appendChild(cell3)
            let cell4 = document.createElement("td")
            cell4.innerHTML = reimb.reimb_resolved
            row.appendChild(cell4)
            let cell5 = document.createElement("td")
            cell5.innerHTML = reimb.reimb_description
            row.appendChild(cell5)
            let cell6 = document.createElement("td")
            cell6.innerHTML = reimb.reimb_type_id_fk
            row.appendChild(cell6)
            let cell7 = document.createElement("td")
            cell7.innerHTML = reimb.reimb_author_fk
            row.appendChild(cell7)
            let cell9 = document.createElement("td")
            cell9.innerHTML = reimb.reimb_status_id_fk
            row.appendChild(cell9)


            document.getElementById("reimbBody").appendChild(row)
        }
    }

}

async function createReimb(){
    get()

    let amount = document.getElementById("amount").value
    let desc = document.getElementById("description").value
    let type = document.getElementById("type").value

    let reimbBody = {
        reimb_amount: amount,
        reimb_submitted: JSON.stringify({'now': new Date()}),
        reimb_description: desc,
        reimb_author_fk: userID,
        reimb_status_id_fk: 1,
        reimb_type_id_fk: type

    }


    let response = await fetch(url + "/createReimb",{
        method:"POST",
        body: JSON.stringify(reimbBody),
        credentials: "include"
    })

    console.log(response.status)

    if(response.status === 202){
        document.getElementById("newReimbDiv").innerText = "Reimb Submitted Successfully"
    }else{
        document.getElementById("failed").innerText = "Reimb Submission Failed"
    }

}

function logout() {
    location.href="http://127.0.0.1:5500/HTML/apartmentcom.html"
    sessionStorage.clear()
}

