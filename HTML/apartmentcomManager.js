const url = "http://localhost:3002"

document.getElementById("allReimbs").onclick = getAllReimbs
document.getElementById("approveButton").onclick = approveReimb
document.getElementById("allReimbs2").onclick = getEmpReimbs
document.getElementById("logout").onclick = logout
document.getElementById("pendReimbs").onclick = getPendReimbs
document.getElementById("appReimbs").onclick = getAppReimbs

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




async function getAllReimbs(){

    get()

    while(document.getElementById("reimbBody").rows.length>0){
        document.getElementById("reimbBody").deleteRow(0);
    }

    let response = await fetch(url + "/getReimbs")

    console.log(response)

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
            let cell8 = document.createElement("td")
            cell8.innerHTML = firstname;
            row.appendChild(cell8)
            let cell9 = document.createElement("td")
            cell9.innerHTML = reimb.reimb_status_id_fk
            row.appendChild(cell9)



            document.getElementById("reimbBody").appendChild(row)


        }

    }
}

async function approveReimb() {

    
    let reimbID = document.getElementById("reimbid").value
    let rstatus = document.getElementById("reimbstatus_id_fk").value

    let reimbDTO = {
        reimb_resolved: JSON.stringify({'now': new Date()}),
        reimb_status_id_fk: rstatus,
        reimb_id: reimbID
    }

    console.log(reimbDTO)

    let response = await fetch (url + "/approve",{
        method: "PUT",
        body: JSON.stringify(reimbDTO),
        credentials: "include"

    })

    console.log(response.staus)

    if(response.status === 202){
        document.getElementById("approvalText").innerText = "Reimb # " + reimbID + " approved."
    }else if(response.status === 200){
        document.getElementById("approvalText").innerText = "Reimb # " + reimbID + " denied."
    }

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
            let cell8 = document.createElement("td")
            cell8.innerHTML = firstname
            row.appendChild(cell8)
            let cell9 = document.createElement("td")
            cell9.innerHTML = reimb.reimb_status_id_fk
            row.appendChild(cell9)


            document.getElementById("reimbBody").appendChild(row)
        }
    }

}

async function getPendReimbs(){

    get()

    while(document.getElementById("reimbBody").rows.length>0){
        document.getElementById("reimbBody").deleteRow(0);
    }

    let response = await fetch(url + "/pending")

    console.log(response)

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
            let cell8 = document.createElement("td")
            cell8.innerHTML = firstname;
            row.appendChild(cell8)
            let cell9 = document.createElement("td")
            cell9.innerHTML = reimb.reimb_status_id_fk
            row.appendChild(cell9)



            document.getElementById("reimbBody").appendChild(row)


        }

    }
}


async function getAppReimbs(){

    get()

    while(document.getElementById("reimbBody").rows.length>0){
        document.getElementById("reimbBody").deleteRow(0);
    }

    let response = await fetch(url + "/approved")

    console.log(response)

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
            let cell8 = document.createElement("td")
            cell8.innerHTML = firstname;
            row.appendChild(cell8)
            let cell9 = document.createElement("td")
            cell9.innerHTML = reimb.reimb_status_id_fk
            row.appendChild(cell9)



            document.getElementById("reimbBody").appendChild(row)


        }

    }
}



function logout() {
    location.href="http://127.0.0.1:5500/HTML/apartmentcom.html"
    sessionStorage.clear()
}