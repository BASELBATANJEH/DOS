const api_url = "http://192.168.182.128:9001/search/";
let aabb = true;
let general_flag = true;
let fff = false;
let rr = null;
let ghg=false;
// async function getData() {
//   const response = await fetch(api_url);
//   const data = await response.json();
//   return data;
// }

// let a = [];
// Promise.all([getData()]).then((values) => {
//   a = values[0].slice();
// });
// console.log(a);

// console.log(r);
var xhttp = new XMLHttpRequest();
xhttp.open("GET", api_url, false);
xhttp.send();
// document.getElementById("categories").innerHTML = xhttp.responseText;

let a = xhttp.responseText;
let b = JSON.parse(a);
console.log(b.length);
console.log(b[1].name);
let makeup = ``;

for (let i = 0; i < b.length; i++) {
  makeup += `<div id='book' onclick='topicclick("${b[i].name}")'>${b[i].name}</div>`;
}
document.getElementById("categories").innerHTML = makeup;
document.getElementById("admin").style.display = " none"; ///////1111111
document.getElementById("book_show").style.gridTemplateColumns =
  "repeat(auto-fill, minmax(400px, 1fr))";
general_flag = true;

function topicclick(r) {
  console.log(r);
  let aaa = r;
  let bbb = aaa.split(" ");
  let ccc = bbb.join("%20");
  console.log(ccc);
  //http://myjson.dit.upm.es/api/bins/b0q9
  xhttp.open("GET", api_url + ccc, false);
  xhttp.send();
  let c = xhttp.responseText;
  let d = JSON.parse(c);
  console.log(d.Books);
  document.getElementById("book_show").innerHTML = "";
  let newbook = ``;
  for (let i = 0; i < d.books.length; i++) {
    newbook += `<div id='book_entity' onclick='bookonclick(${d.books[i].id})'><div class="bookbook">
      <span></span>
    </div>`;
    newbook += `<div id="booktext"><div>${d.books[i].title}</div></div></div>`;
  }
  document.getElementById("book_show").innerHTML = newbook;
  document.getElementById("admin").style.display = " none"; ///////1111111
  document.getElementById("book_show").style.gridTemplateColumns =
    "repeat(auto-fill, minmax(400px, 1fr))";

  general_flag = true;
  fff = false;
  document.getElementById("admin").style.backgroundColor = "white";
  document.getElementById("admin").style.color = "black";
  document.getElementById("admin").style.cursor = "pointer";
}

function bookonclick(s) {
  xhttp.open("GET", "http://192.168.182.128:9001/books/info/" + s, false);
  xhttp.send();
  let c = xhttp.responseText;
  let d = JSON.parse(c);
  console.log(d);
  console.log(d.quantity);
  document.getElementById("book_show").innerHTML = "";
  aabb = true;
  let newbookk = ``;
  newbookk += `<div id='book_entity'><div class="bookbook">
      <span></span>
    </div>`;
  newbookk += `<div id="booktext"><div>${d.title}</div><div>${d.quantity}<span id='err'>Sorry,the quantity is 0. You cannot buy now</span></div><div>${d.price}$</div><div onclick='buyfunc("${d.quantity}","${s}")' id="lastdiv">Buy<br>Now!<span id='success'>Successful Buy :)</span></div><div style='display:none;' onclick='updatequantityy("${s}")' id='updatequantity'>Update<br>Quantity</div><div style='display:none;' onclick='updatepricee("${s}")' id='updateprice'>Update<br>Price</div></div></div>`;
  document.getElementById("book_show").innerHTML = newbookk;
  document.getElementById("book_entity").style.cursor = "context-menu";
  document.getElementById("lastdiv").style.cursor = "pointer";
  if(ghg){
    document.getElementById("lastdiv").style.display = "none";
    document.getElementById("updatequantity").style.display = "flex";
    document.getElementById("updateprice").style.display = "flex";
    ghg =false;
    }
  
  if (document.getElementById("updatequantity") != null) {
    document.getElementById("updatequantity").style.cursor = "pointer";
    document.getElementById("updateprice").style.cursor = "pointer";
  }
  document.getElementById("success").style.display = "none";
  document.getElementById("admin").style.display = " block"; ///////1111111
  // fff = false;
}

function buyfunc(o, s) {
  if (o <= 0 && aabb === true) {
    console.log("ERROR");

    document.getElementById("err").style.display = "block";
    window.setTimeout("closeHelpDiv();", 4000);
    aabb = false;
  } else {
    xhttp.open("PUT", "http://192.168.182.129:9092/order/purchase/" + s, false);
    xhttp.send();
    document.getElementById("success").style.display = "block";
    window.setTimeout(bookonclick(s), 50000);
  }
  if (fff) {
    // adminclick();
    // general_flag = true;
    document.getElementById("booktext").innerHTML = rr;
    if (document.getElementById("updatequantity") != null) {
      document.getElementById("updatequantity").style.display = "flex";
      document.getElementById("updateprice").style.display = "flex";
    }
  }
}

function closeHelpDiv() {
  document.getElementById("err").style.display = " none";
  aabb = true;
}

function adminclick() {
  if (general_flag) {
    // document.getElementById("booktext").innerHTML +=
    // "<div onclick='updatequantityy()' id='updatequantity'>Update<br>Quantity</div><div onclick='updatepricee()' id='updateprice'>Update<br>Price</div>";
    general_flag = false;
    rr = document.getElementById("booktext").innerHTML;
    document.getElementById("updatequantity").style.display = "flex";
    document.getElementById("updateprice").style.display = "flex";
    document.getElementById("lastdiv").style.display = "none";

    console.log(rr);
    document.getElementById("book_show").style.gridTemplateColumns =
      "repeat(auto-fill, minmax(600px, 1fr))";
    document.getElementById("updatequantity").style.cursor = "pointer";
    document.getElementById("updateprice").style.cursor = "pointer";
    fff = true;
    document.getElementById("admin").style.backgroundColor = "grey";
    document.getElementById("admin").style.color = "white";
    document.getElementById("admin").style.cursor = "context-menu";

    ("block !important");
  } else {
  }
}

function updatequantityy(s) {
  let t = prompt("Please enter new quantity value");
  while (t < 0) {
    window.alert("Your value must be larger or equal to 0");
    t = prompt("Please enter new Quantity value");
  }
  xhttp.open(
    "PUT",
    "http://192.168.182.128:9001/books/update/" + s + "?quantity=" + t,
    false
  );
  xhttp.send();
  ghg=true;
  window.setTimeout(bookonclick(s), 50000);
 


}

function updatepricee(s) {
  let t = prompt("Please enter new price");
  while (t <= 0) {
    window.alert("Your value must be larger than 0");
    t = prompt("Please enter new Quantity value");
  }
  xhttp.open(
    "PUT",
    "http://192.168.182.128:9001/books/update/" + s + "?price=" + t,
    false
  );
  xhttp.send();
  ghg=true;
  window.setTimeout(bookonclick(s), 50000);
 

}
