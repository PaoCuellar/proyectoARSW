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
        var users = "<tr>\n" +
                    "<th>Usuario</th>\n" +
                    "<th>Nombre</th>\n" +
                    "<th>Correo</th>\n" +
                    "<th>Ciudad</th>\n" +
                    "</tr>";


        for (const user of data){

            users +="<tr>\n" +
                    "<th>" + user.userName + "</th>\n" +
                    "<th>" + user.name + "</th>\n" +
                    "<th>" + user.email + "</th>\n" +
                    "<th>" + user.ciudad + "</th>\n" +
                    "</tr>"
        }
        document.getElementById('UserTable').innerHTML =users;
    });


    $.get("https://subastasdinipa.herokuapp.com/subastas/categorias", function(data, status){
        console.log("Data: ",data, "\nStatus: ", status);
        var categorys = "<tr>\n" +
                        "<th>Categoría</th>\n" +
                        "<th>Descripción</th>\n" +
                        "</tr>";


        for (const category of data){

            categorys +="<tr>\n" +
                        "<th>" + category.category + "</th>\n" +
                        "<th>" + category.description + "</th>\n" +
                        "</tr>"
        }
        document.getElementById('CategoryTable').innerHTML =categorys;
    });
})

