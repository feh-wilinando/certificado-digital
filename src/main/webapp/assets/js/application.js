$(document).ready(function() {

    var telefoneMaskBehavior = function(val){
        return val.replace(/\D/g, '').startsWith("0800")? '0000 0000-0000': '(00) 0000-0000';
    };

    var option = {
        onKeyPress: function(val, e, field, options){
            field.mask(telefoneMaskBehavior.apply({}, arguments), options);
        }
    };

    $('.cnpj-mask').mask('00.000.000/0000-00');
    $('.cep-mask').mask('00000-000');
    $('.telefone-mask').mask(telefoneMaskBehavior, option);
    $('.celular-mask').mask('(00) 0 0000-0000');
    $('.horario-mask').mask('00:00');


    $(':checkbox').checkboxpicker({offLabel: "Não", onLabel: "Sim", onActiveCls: "btn-primary"});

    $("#useRegisteredData").change(function () {
        $("#additional-data").slideToggle();
    })

});