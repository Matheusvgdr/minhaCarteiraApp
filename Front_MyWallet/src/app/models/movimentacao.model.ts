import { Cartao } from "./cartao.model";
import { Carteira } from "./carteira.model";
import { Conta } from "./conta.model";
import { TT } from "./tipoTransacao.mode";

export {Movimentacao as Movi}

interface Movimentacao{
    id: number;
    dataMovimentacao: Date;
    dinheiro: number;
    id_tipo: TT;
    id_carteira: Carteira;
    id_conta: Conta;
    id_cartao: Cartao;
}