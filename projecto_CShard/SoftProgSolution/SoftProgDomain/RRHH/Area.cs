using System;
using System.Collections.Generic;
using System.Text;

namespace SoftProgDomain.RRHH
{
    public class Area
    {
        private int idArea;
        private String? nombre;
        private bool activo;

        public Area(int idArea, string? nombre, bool activo)
        {
            this.idArea = idArea;
            this.nombre = nombre;
            this.activo = activo;
        }

        public int IdArea { get => idArea; set => idArea = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public bool Activo { get => activo; set => activo = value; }
    }
}
