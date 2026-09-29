using System;
using System.Collections.Generic;
using System.Text;

namespace SoftProgDomain.RRHH
{
    public class Persona
    {
        private int idPersona;
        private String DNI;
        private String nombre;
        private String apellidoPaterno;
        private char genero;
        private DateTime fechaNacimiento;

        public Persona(int idPersona, string dNI, string nombre, string apellidoPaterno, char genero, DateTime fechaNacimiento)
        {
            this.idPersona = idPersona;
            DNI = dNI;
            this.nombre = nombre;
            this.apellidoPaterno = apellidoPaterno;
            this.genero = genero;
            this.fechaNacimiento = fechaNacimiento;
        }

        public int IdPersona { get => idPersona; set => idPersona = value; }
        public string DNI1 { get => DNI; set => DNI = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string ApellidoPaterno { get => apellidoPaterno; set => apellidoPaterno = value; }
        public char Genero { get => genero; set => genero = value; }
        public DateTime FechaNacimiento { get => fechaNacimiento; set => fechaNacimiento = value; }
    }
}
