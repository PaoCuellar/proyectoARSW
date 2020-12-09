$(document).ready(function() {
    $.get("https://subastasdinipa.herokuapp.com/subastas/categorias", function(data, status){
        var categorys = "";


        for (const category of data){

            categorys +="<li class='item1'>" +
                        "<a href='#'>" +
                        "<img class='arrow-img' src='images/f_menu.png' alt=''/>" +
                        category.category + "</a>" +
                        "</li>"
        }
        document.getElementById('listCategorias').innerHTML =categorys;
    });

    /* $.get("https://subastasdinipa.herokuapp.com/subastas", function(data, status){
        console.log("Data: ",data, "\nStatus: ", status);
        var subasta = "";


        for (const subasta of data){

            subastas +="<div class='col-md-4 box_2'>" +
                            "<div class='grid_1'>" +
                                "<div class='b-link-stroke b-animate-go  thickbox'>" +
                                    "<img src='images/producto.png' class='img-responsive' alt=''/>" +
                                "</div>" +
                                "<div class='grid_2'>" +
                                    "<p>" + subasta.name + "</p>" +
                                    "<ul class='grid_2-bottom'>" +
                                        "<li class='grid_2-left'>" + "<p>" + subasta.hopedPrice + "</p>" + "</li>" +
                                        "<li class='grid_2-right'>" + 
                                            "<div class='btn btn-primary btn-normal btn-inline' onclick='subastas.setSubastaId('subasta.id)'  target='_self' title='Get It'>" + "Ofertar" + 
                                            "</div>" + 
                                        "</li>" +
                                        "<div class='clearfix'>" + "</div>" +
                                    "</ul>" +
                                "</div>" +
                            "</div>" +
                        "</div>"
        }
        document.getElementById('listCategorias').innerHTML =subastas;
    }); */
})