package com.example.soluciontaller3lr.notas;

public enum NotasString {
   ADMINISTRACION("administracion"),
   CODIGO("codigo"),
   NOMBRE("nombre"),
   NOTA1("nota1"),
   NOTA2("nota2"),
   NOTA3("nota3"),
   NOTA4("nota4"),
   TOTAL("total"),
   NOTAS("notas"),
   DIMENSION(""),
   REGISTROEXITOSO("Registro exitoso"),
   REGISTROFALLIDO("Debes llenar todos los campos"),
   PROMEDIO("Su promedio es de : "),
    ;

    private String msj;

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    NotasString(String msj) {
        this.msj = msj;
    }
}
