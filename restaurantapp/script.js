
// Search bar for Tables
function tableSearch() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("tInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}


var tables = [{table_id: 1, num_of_items: 0, items: [], Bill: 0},
          {table_id: 2, num_of_items: 0, items: [], Bill: 0},
          {table_id: 3, num_of_items: 0, items: [], Bill: 0},
          {table_id: 4, num_of_items: 0, items: [], Bill: 0},
          {table_id: 5, num_of_items: 0, items: [], Bill: 0},
          {table_id: 6, num_of_items: 0, items: [], Bill: 0},
          {table_id: 7, num_of_items: 0, items: [], Bill: 0}];
          
          
var menu_items = [{item_id: 1, item_name: "Veg Corn Soup", cost: 80, category: "soup"},
            {item_id: 2,  item_name: "Veg Hot & Sour Soup", cost: 80, category: "soup"},
            {item_id: 3,  item_name: "Veg Manchow Soup", cost: 80, category: "soup"},
            {item_id: 4,  item_name: "Chicken Manchow Soup", cost: 100, category: "soup"},
            {item_id: 5,  item_name: "Chicken Corn Soup", cost: 100, category: "soup"},
            {item_id: 6,  item_name: "Chicken Hot and Sour Soup", cost: 100, category: "soup"},
            {item_id: 7,  item_name: "Paneer Tikka", cost: 150, category: "starter"},
            {item_id: 8,  item_name: "Tandoori Chicken", cost: 150, category: "starter"},
            {item_id: 9,  item_name: "Chicken Tikka", cost: 150, category: "starter"},
            {item_id: 10, item_name: "Reshmi Kebab", cost: 150, category: "starter"},
            {item_id: 11, item_name: "Paneer 65", cost: 150, category: "starter"},
            {item_id: 12, item_name: "Baby Corn Chilli", cost: 150, category: "starter"},
            {item_id: 13, item_name: "Gobi Chilli", cost: 150, category: "starter"},            
            {item_id: 14, item_name: "Veg Mixed Curry ", cost: 130, category: "main course"},
            {item_id: 15, item_name: "Veg Kadhai", cost: 150, category: "main course"},
            {item_id: 16, item_name: "Paneer Butter Masala", cost: 140, category: "main course"},
            {item_id: 17, item_name: "Paneer Shahi Korma", cost: 200, category: "main course"},
            {item_id: 18, item_name: "Mushroom Andhra", cost: 160, category: "main course"},
            {item_id: 19, item_name: "Chicken Masala", cost: 190, category: "main course"},
            {item_id: 20, item_name: "Chicken Fry", cost: 190, category: "main course"}];


var initialTables = [{Table_id: "t1", table_name: "Table 1", table_num: "1"},
              {Table_id: "t2", table_name: "Table 2", table_num: "2"},
              {Table_id: "t3", table_name: "Table 3", table_num: "3"},
              {Table_id: "t4", table_name: "Table 4", table_num: "4"},
              {Table_id: "t5", table_name: "Table 5", table_num: "5"},
              {Table_id: "t6", table_name: "Table 6", table_num: "6"},
              {Table_id: "t7", table_name: "Table 7", table_num: "7"},
              {Table_id: "t8", table_name: "Table 8", table_num: "8"}];
              

// Search bar for Menu
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myMenu");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

// Load Menu

function loadMenu() {
  
  for (var i = 0; i < menu_items.length; i++) {
    var row = document.createElement("tr");
      var td = document.createElement("td");
      row.id = menu_items[i].item_id;
      row.setAttribute("draggable", "true");
      row.setAttribute("ondragstart", "drag(event)");
      //var div = document.createElement("div");
      var items = document.createElement("h4");
      items.innerHTML = menu_items[i].item_name;
      var cost = document.createElement("p");
      cost.innerHTML = menu_items[i].cost + ",  " + menu_items[i].category;
 
      
      document.getElementById("myMenu").appendChild(row);
      row.appendChild(td);
      td.appendChild(items);
      td.appendChild(cost);
   }    
}           
loadMenu();           


//Load Tables
function loadTables() {
   
   for (var i = 0; i < initialTables.length; i++) {
    
    //create table elements 
    var row = document.createElement("tr");
      var td = document.createElement("td");
      var tname = document.createElement("h4");
      var rs = document.createElement("p");
      var cost = document.createElement("p");
      var sep = document.createElement("p");
      var tItems = document.createElement("p");
      var items_num = document.createElement("p");
      
      //add attributes and elements.
      row.id = initialTables[i].Table_id;
      row.className = "table-" + initialTables[i].table_num;
      td.className = "table-" + initialTables[i].table_num;
      td.setAttribute("ondrop", "drop(event)");
      td.setAttribute("ondragover", "allowDrop(event)");
      td.setAttribute("onclick", "openModal(this)");
      tname.className = "table-" + initialTables[i].table_num;
      tname.innerHTML = initialTables[i].table_name;
      rs.className = "table-" + initialTables[i].table_num;
      rs.style.display = "inline";
      rs.innerHTML = "Rs. ";
      cost.className = "table-" + initialTables[i].table_num;
      cost.style.display = "inline";
      cost.innerHTML = 0;
      cost.id = "totalBill";
      sep.className = "table-" + initialTables[i].table_num;
      sep.style.display = "inline";
      sep.innerHTML = " | ";
      tItems.className = "table-" + initialTables[i].table_num;
      tItems.style.display = "inline";
      tItems.innerHTML = "Total Items:";
      items_num.className = "table-" + initialTables[i].table_num;
      items_num.style.display = "inline";
      items_num.innerHTML = 0;
      items_num.id = "numItems";
      
      
      //append child
      document.getElementById("myTable").appendChild(row);
      row.appendChild(td);
      td.appendChild(tname);
      td.appendChild(rs);
      td.appendChild(cost);
      td.appendChild(sep);
      td.appendChild(tItems);
      td.appendChild(items_num);        
   }    

}
loadTables();


var modal = document.getElementById('myModal');
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];
span.onclick = function() {
   removeAll();
    modal.style.display = "none";
    for (var i = 0; i < initialTables.length; i++) {
      document.getElementById(initialTables[i].Table_id).style.backgroundColor = "white";
    }
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        removeAll();
        modal.style.display = "none";
        for (var i = 0; i < initialTables.length; i++) {
          document.getElementById(initialTables[i].Table_id).style.backgroundColor = "white";
        }     
    }
}               




// Drag and drop
function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    var item_name = menu_items[data - 1].item_name;
    var cost = menu_items[data-1].cost;
    var classiden = ev.target.className;
    var iden = classiden.substr(-1);
    if (iden != "") {
         //if item is already present.
         var i, sameI;
         var len = tables[iden-1].items.length;
         console.log(len);
         for (i = 0; i < len; i++) {
        if (tables[iden-1].items[i].item_name == item_name) {
              sameI = i; break;     
        }        
         }
         
         // update the tables object.
         if (len == 0) {
          tables[iden-1].Bill = cost;
        tables[iden-1].items[len] = {sno: len+1, item_name: item_name, price: cost, quant: 1};
        tables[iden-1].num_of_items = 1;
          
         } else if (Number.isInteger(sameI)) {
        tables[iden-1].items[i].quant += 1;
        tables[iden-1].items[i].price += cost;
        tables[iden-1].Bill += cost;               
         } else {
        var len = tables[iden-1].items.length;
          tables[iden-1].Bill = tables[iden-1].Bill + cost;
        tables[iden-1].items[len] = {sno: len+1, item_name: item_name, price: cost, quant: 1};
        tables[iden-1].num_of_items += 1;
      }
      
      // update the display on tables.
      var classes = document.getElementsByClassName(classiden);
      classes[4].innerHTML = tables[iden-1].Bill;
      classes[7].innerHTML = tables[iden-1].num_of_items;
    }
    }

// When the user clicks the button, open the modal 
function openModal(element) {
  
   var i;
    var classiden = element.className;
    element.parentElement.style.backgroundColor = "orange";
    var iden = classiden.substr(-1); 
    var len = tables[iden-1].items.length;    
    document.getElementById("tableNum").innerHTML = iden;
       
    if (iden != "" && len > 0 ) {
      for (i = 0; i < len; i++) { 
            
    //create a row.
    var row = document.createElement("tr");
      var td1 = document.createElement("td");
      var td2 = document.createElement("td");
      var td3 = document.createElement("td");
      var td4 = document.createElement("td");
      var input = document.createElement("input");
      var td5 = document.createElement("td");     
      var delbutton = document.createElement("button");
      
      // add attributes
      td1.className = "modalserial";
      td2.className = "modalItemName";
      td3.className = "modalPrice";
      td4.className = "modalQuant" 
      input.setAttribute("type", "number");
      input.setAttribute("min", 1);
      input.setAttribute("onkeypress", "return event.charCode >= 48");
      input.setAttribute("oninput", "editServings(this)");
      //input.setAttribute("max", 10);
      delbutton.setAttribute("onclick", "deleteItem(this)");
      delbutton.className = "modalDelete";
      
      //add values
      delbutton.innerHTML = "Delete";
      td1.innerHTML = tables[iden-1].items[i].sno;
      td2.innerHTML = tables[iden-1].items[i].item_name;
      td3.innerHTML = tables[iden-1].items[i].price;
      input.value = tables[iden-1].items[i].quant;
      
      //append all
      td4.appendChild(input);
      td5.appendChild(delbutton);
      row.appendChild(td1);
      row.appendChild(td2);
      row.appendChild(td3);
      row.appendChild(td4);
      row.appendChild(td5);
      
      var table = document.getElementById("modalTableBody");
      table.appendChild(row);  
      }
      
      //Total bill
      document.getElementById("totalAmt").innerHTML = tables[iden-1].Bill;      
    }
    modal.style.display = "block";
}


// Removing all from Modal.
function removeAll() {
    var table = document.getElementById("modalTableBody");
    while (table.hasChildNodes()) {
        table.removeChild(table.lastChild);
    }
    document.getElementById("totalAmt").innerHTML = "";
 }


//on changing servings
function editServings(element) {
  //Get the values and ids
    var tableId = document.getElementById("tableNum").innerHTML;
    var row = element.parentElement.parentElement;
    var serial = row.firstChild.innerHTML;
    var it_name = row.childNodes[1].innerHTML;
    var menu_len = menu_items.length;
    var i, singlePrice;
    for (i = 0; i < menu_len; i++) {
      if (menu_items[i].item_name == it_name) {
          var singlePrice = menu_items[i].cost;
          break;       
       }        
    }
    
    //change table memory
    tables[tableId - 1].items[serial-1].quant = element.value;
    tables[tableId - 1].items[serial-1].price = element.value * singlePrice;
    tables[tableId - 1].Bill = 0;
    var items_len = tables[tableId - 1].items.length;
    for (i = 0; i < items_len; i++) {
      tables[tableId - 1].Bill += tables[tableId - 1].items[i].price;     
    }   

    //Now update the display
    row.childNodes[2].innerHTML = tables[tableId - 1].items[serial-1].price;
    var classes = document.getElementsByClassName("table-"+tableId);
    classes[4].innerHTML = tables[tableId-1].Bill;
    document.getElementById("totalAmt").innerHTML = tables[tableId - 1].Bill;     
}

//on deleting an item
function deleteItem(element) {
    var rowDel = element.parentElement.parentElement;
    var tableBody = rowDel.parentElement;
      var tableId = document.getElementById("tableNum").innerHTML;
      var serial = rowDel.firstChild.innerHTML;
      rowDel.remove();
    
    //update serial
    var tableSno = document.getElementsByClassName("modalserial");    
    var i;
    for (i = 0; i < tableSno.length; i++) {
      tableSno[i].innerHTML = i + 1;    
    }
    

    //Update table memory
    tables[tableId - 1].items.splice(serial-1, 1);    
     tables[tableId - 1].Bill = 0;
     var items_len = tables[tableId - 1].items.length;
      tables[tableId - 1].num_of_items = items_len;    
  
       for (i = 0; i < items_len; i++) {
      tables[tableId - 1].Bill += tables[tableId - 1].items[i].price;     
          tables[tableId-1].items[i].sno = i+1;
       }
       
       //update display
       document.getElementById("totalAmt").innerHTML = tables[tableId - 1].Bill;
       var classes = document.getElementsByClassName("table-"+tableId);
        classes[4].innerHTML = tables[tableId - 1].Bill;
     classes[7].innerHTML = tables[tableId - 1].num_of_items;
          
}
  
var billmodal = document.getElementById('billModal');
var span1 = document.getElementsByClassName("close1")[0];
function genBill() {
   var tableId = document.getElementById("tableNum").innerHTML;
   var bill = document.getElementById("totalAmt").innerHTML;
   var disBill = document.getElementById("totalBill").innerHTML;
    removeAll();
    
    //remove from table memory
    if (tableId != ""){
      tables[tableId - 1] = {table_id: tableId, num_of_items: 0, items: [], Bill: 0};
    }
    modal.style.display = "none";
    document.getElementById("tablenum").innerHTML = tableId;
    document.getElementById("billAmt").innerHTML = bill;
    billmodal.style.display = "block";
    var classes = document.getElementsByClassName("table-"+tableId);
   classes[4].innerHTML = 0;
   classes[7].innerHTML = 0;
} 

//close bill
function pay() {
  for (var i = 0; i < initialTables.length; i++) {
   document.getElementById(initialTables[i].Table_id).style.backgroundColor = "white";
   }
  billmodal.style.display = "none";
    }

