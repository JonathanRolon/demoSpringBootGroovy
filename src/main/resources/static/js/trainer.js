window.onload = function(){
    console.log("logged");

    function activar(event){
       var oInputName = $('#_idName').get(0),
           oInputLevel = $('#_idLevel').get(0),
           oButtonSubmit = $('#_idButtonSubmit').get(0),
           oButtonCancel = $('#_idButtonCancel').get(0),
           oButtonEdit = $('#_idButtonOpenEditTrainer').get(0);

       oButtonEdit.disabled = true;
       oInputName.disabled = !oInputName.disabled;
       oInputLevel.disabled = !oInputLevel.disabled;
       oButtonSubmit.disabled = !oButtonSubmit.disabled;
       oButtonCancel.disabled = !oButtonCancel.disabled;
       oButtonEdit.disabled = oButtonCancel.disabled ? false : true;

       return;
     }
    /*** trainer.html ***/
     let oButtonEdit = $('#_idButtonOpenEditTrainer'),
        oButtonCancel = $('#_idButtonCancel');
     oButtonEdit.click(activar);
     oButtonCancel.click(activar);

    /*** trainers.html ***/
    let oButtonDeleteTrainer = $('#_idDeleteTrainer');

    oButtonDeleteTrainer.click(onPressDeleteTrainer);

    function onPressDeleteTrainer(){

    }
};
