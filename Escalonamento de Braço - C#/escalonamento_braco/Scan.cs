using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace escalonamento_braco
{
    public sealed class Scan
    {
        private static readonly Scan instance = new Scan();

        private List<int?> requisicoes;
        private static int tamanho_disco;
        private int i;


        static Scan()
        {
        }

        private Scan()
        {

            requisicoes = new List<int?>();
            i = 1;
            tamanho_disco = 40;
            for (int i = 0; i <= tamanho_disco; i++)
            {
                requisicoes.Add(null);
            }
        }


        public void Executa()
        {
            if(i == 1)
            {
                while (i <= tamanho_disco) //possuiRequisicao()
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

                    Thread.Sleep(300);

                }

            }
            else
            {
                i -= 1;

                while (i > 0) //possuiRequisicao()
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

                    i -= 1;

                    Thread.Sleep(300);

                }
                
            }
            

            
        }

        private void resolverRequisicao(int i)
        {
            requisicoes[i] = null;
        }

        private bool possuiRequisicao()
        {
            return requisicoes.Where(r => r.HasValue).Count() > 0;
        }

        public static Scan Instance
        {
            get
            {
                return instance;
            }
        }

        public void NovaRequisicao(int numero_requisicao)
        {
            //if (numero_requisicao > tamanho_disco)
            //    throw new Exception("número da requisição deve ser menor que tamanho do disco");

            requisicoes[numero_requisicao-1] = numero_requisicao;
        }
    }
}
