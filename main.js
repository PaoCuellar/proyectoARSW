var subastas =  (function () {
    function setSubastaC(subastaId){
        document.cookie =  subastaId;
    }
    
    return {
        
        setSubastaId: function(subastaId){
            setSubastaC(subastaId);
        }
        
    };
    
})();