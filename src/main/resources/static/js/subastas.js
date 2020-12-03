var subastas =  (function () {
    function setSubastaC(subastaId){
        document.cookie =  "subastaId = "+subastaId+";path=/;  ";
        location.replace("https://subastasdinipa.herokuapp.com/product.html");
        
    }
    
    return {
        
        setSubastaId: function(subastaId){
            setSubastaC(subastaId);
        }
        
    };
    
})();