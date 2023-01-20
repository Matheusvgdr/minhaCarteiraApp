import { Banco } from "./banco.model";
import { Carteira } from "./carteira.model";
import { Usuario } from "./usuario.model";

export interface Item{
    id?: number;
    conteudo: string;
    dinheiro: number;
    id_usuario: Usuario;
    id_carteira: Carteira;
    id_banco: Banco;
}