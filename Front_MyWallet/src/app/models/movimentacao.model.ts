import { Banco } from "./banco.model";
import { Carteira } from "./carteira.model";
import { TT } from "./tipoTransacao.mode";
import { Usuario } from "./usuario.model";

export {Movimentacao as Movi}

interface Movimentacao{
    id?: number;
    dataMovimentacao: String;
    dinheiro: number;
    id_tipo: TT;
    id_carteira?: Carteira;
    id_usuario: Usuario;
    id_banco: Banco;
}