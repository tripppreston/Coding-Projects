$(document).ready(function () {
    var balance;
    loadItems();

    $('#getChangeButton').click(function (event){
       event.preventDefault();
       $('#change').val('0.00');
        
    });


    $('#insertButton').click(function (event) {
        event.preventDefault();
        var insertedMoney = parseFloat($('#insertedMoney').val());
        var currentBalance = parseFloat($('#currentMoney').val());
        balance = (insertedMoney + currentBalance).toFixed(2);

        $('#currentMoney').val(balance);
        $('#insertedMoney').val('0.00');
//        $('#change').val('');
    });
});

function processItemList(items) {

    var itemRows = $('#itemRows');
    $.each(items, function (index, item) {

        var nameField = $("<td>");
        var priceField = $("<td>");
        var buyField = $("<td>");



        

        priceField.text(item.price);
        nameField.text(item.name);

        var buyLink = $("<a>");
        buyLink.attr({'onclick': 'buyItem(this)',
            'data-item-id': item.id,
            'data-item-name': item.name,
            'data-item-price': item.price,
            'data-item-numberAvailable': item.numberAvailable,
            'class': 'buyLinks'});
        buyLink.text("Buy");
        buyField.append(buyLink);


        var itemRow = $("<tr>");
        itemRow.append(nameField);
        itemRow.append(priceField);
        itemRow.append(buyField);

        itemRows.append(itemRow);
    });
}
function fillItemTable(itemList, status) {
    var itemRows = $('#itemRows');
    $.each(itemList, function (index, item) {

        var nameField = $("<td>");
        var priceField = $("<td>");
        var buyField = $("<td>");



        nameField.attr({
            'class': 'itemName'
        });

        priceField.text(item.price);
        nameField.text(item.name);


        var buyLink = $("<a>");
        buyLink.attr({'onclick': 'buyItem(this)',
            'data-item-id': item.id,
            'data-item-name': item.name,
            'data-item-price': item.price,
            'data-item-numberAvailable': item.numberAvailable,
            'class': 'buyLinks'});
        buyLink.text("Buy");
        buyField.append(buyLink);


        var itemRow = $("<tr>");
        itemRow.append(nameField);
        itemRow.append(priceField);
        itemRow.append(buyField);

        itemRows.append(itemRow);
    });
}

function clearItemTable() {
    $('#itemRows').empty();
}

function loadItems() {


    var itemContents = $('#itemRows');
    clearItemTable();
    $.ajax({
        url: 'items'
    }).success(function (data, status) {
        fillItemTable(data, status);
    });
}

function buyItem(element) {
    console.dir(element);
    var itemId = element.dataset.itemId;
    var itemName = element.dataset.itemName;
    var itemPrice = element.dataset.itemPrice;
    var newAmount = element.dataset.itemNumberavailable - 1;
    var data = JSON.stringify({
        id: itemId,
        name: itemName,
        price: itemPrice,
        numberAvailable: newAmount
    });
    var currentBalance = parseFloat($('#currentMoney').val());
    var cost = parseFloat(itemPrice);
    var newBalance = (currentBalance - cost);
    if (currentBalance >= cost) {
        $('#currentMoney').val('0.00');
        $('#change').val(newBalance).toFixed(2);
        $.ajax({
            url: 'item/' + itemId,
            type: 'PUT',
            headers: {'Content-Type': 'application/json'

            },
            'dataType': 'json',
            data: data
        }).success(function () {
            loadItems();

        });
    } else {
        alert("Insufficient Funds");
    }

}


