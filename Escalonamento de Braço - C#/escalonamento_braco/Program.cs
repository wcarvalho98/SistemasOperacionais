using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace escalonamento_braco
{
    class Program
    {
        static void Main(string[] args)
        {
            //C_scan c_scan = C_scan.Instance;

            //c_scan.NovaRequisicao(8);
            //c_scan.NovaRequisicao(1);
            //c_scan.NovaRequisicao(5);

            //c_scan.Executa();

            //c_scan.NovaRequisicao(16);

            //c_scan.NovaRequisicao(34);
            //c_scan.NovaRequisicao(40);

            //c_scan.Executa();

            Scan scan = Scan.Instance;

            scan.NovaRequisicao(8);
            scan.NovaRequisicao(1);
            scan.NovaRequisicao(5);
            scan.NovaRequisicao(16);

            scan.Executa();
            Console.ReadLine();

            scan.NovaRequisicao(34);
            scan.NovaRequisicao(40);

            scan.Executa();

            Console.ReadLine();
        }
    }
}
