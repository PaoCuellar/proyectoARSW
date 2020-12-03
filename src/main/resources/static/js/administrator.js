$(document).ready(function() {
        $.get("https://subastasdinipa.herokuapp.com/subastas/items", function(data, status){
            console.log("Data: ",data, "\nStatus: ", status);
            var items = "<tr>\n" +
                            "<th>Producto</th>\n" +
                            "<th>Precio</th>\n" +
                            "<th>Vendido</th>\n" +
                        "</tr>";


            for (const item of data){

                items +="<tr>\n" +
                        "<th>" + item.description + "</th>\n" +
                        "<th>" + item.hopedPrice + "</th>\n" +
                        "<th>" + item.sold + "</th>\n" +
                        "</tr>"
            }
            document.getElementById('ItemTable').innerHTML =items;
        });


    $.get("https://subastasdinipa.herokuapp.com/subastas/usuarios", function(data, status){
        console.log("Data: ",data, "\nStatus: ", status);
        var items = "<tr>\n" +
                    "<th>Producto</th>\n" +
                    "<th>Precio</th>\n" +
                    "<th>Vendido</th>\n" +
                    "</tr>";


        for (const item of data){

            items +="<tr>\n" +
                    "<th>" + item.description + "</th>\n" +
                    "<th>" + item.hopedPrice + "</th>\n" +
                    "<th>" + item.sold + "</th>\n" +
                    "</tr>"
        }
        document.getElementById('ItemTable').innerHTML =items;
    });


    $.get("https://subastasdinipa.herokuapp.com/subastas/categorias", function(data, status){
        console.log("Data: ",data, "\nStatus: ", status);
        var items = "<tr>\n" +
                    "<th>Producto</th>\n" +
                    "<th>Precio</th>\n" +
                    "<th>Vendido</th>\n" +
                    "</tr>";


        for (const item of data){

            items +="<tr>\n" +
                    "<th>" + item.description + "</th>\n" +
                    "<th>" + item.hopedPrice + "</th>\n" +
                    "<th>" + item.sold + "</th>\n" +
                    "</tr>"
        }
        document.getElementById('ItemTable').innerHTML =items;
    });
})

