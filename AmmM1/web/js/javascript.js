
function createElement(user){
    
    var link=$("<a>")
            .attr("href","Bacheca?utente="+user.id)
            .html(user.nome+" "+user.cognome);
    
    return $("<li>")
            .attr("class","picutente")
            .append(link);
}

function stateSuccess(data) {
    var userListPage = $("#usersList");

    $(userListPage).empty();
    
    if(data[0]===undefined){
        $(userListPage).html("Nessun utente trovato");
    }
    else{
        for (var instance in data) {
            $(userListPage).append(createElement(data[instance]));
        }
    }
    
    
}
function stateFailure(data, state) {
    console.log(state);
}

$(document).ready(function(){
    
    $("#searchField").on('keyup',function(){
        var wantedUser = $("#searchField")[0].value;
        
        $.ajax({
            url: "filter.json",
            data:{
                q:wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
    
    $("#buttonSearch").click(function(){
        
        var wantedUser = $("#searchField")[0].value;
        
        $.ajax({
            url: "filter.json",
            data:{
                q:wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })

});

