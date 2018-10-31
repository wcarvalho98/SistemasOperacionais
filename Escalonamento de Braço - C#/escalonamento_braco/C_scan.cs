using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace escalonamento_braco
{
    public sealed class C_scan
    {
        private static readonly C_scan instance = new C_scan();

        private List<int?> requisicoes;
        private static int tamanho_disco;
        private int i;
        

        static C_scan()
        {
        }

        private C_scan()
        {
            
            requisicoes = new List<int?>();
            i = 1;
            tamanho_disco = 40;
            for (int i = 0; i < tamanho_disco; i++)
            {
                requisicoes.Add(null);
            }
        }
        

        public void Executa()
        {
            while (i <= tamanho_disco)//possuiRequisicao()
            {
                

                if (requisicoes[i-1].HasValue)
                {
                    Console.WriteLine("Posição do disco: " + i.ToString() + " | Requisição: " + (i).ToString());
                    resolverRequisicao(i-1);
                }
                else
                {
                    Console.WriteLine("Posição do disco: " + i.ToString() + " | Vazia");
                }

                i += 1;

                //if (i == tamanho_disco)
                //    i = 0;

                Thread.Sleep(300);
                
            }

            i = 1;
        }

        private void resolverRequisicao(int i)
        {
            requisicoes[i] = null;
        }

        private bool possuiRequisicao()
        {
            return requisicoes.Where(r => r.HasValue).Count() > 0;
        }

        public static C_scan Instance
        {
            get
            {
                return instance;
            }
        }

        public void NovaRequisicao(int numero_requisicao)
        {
            //if (numero_requisicao >= tamanho_disco)
            //    throw new Exception("número da requisição deve ser menor que tamanho do disco");

            requisicoes[numero_requisicao-1] = numero_requisicao;
        }
    }
}
