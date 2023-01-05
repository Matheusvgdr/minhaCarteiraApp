import { Banco } from "./banco.model";
import { Usuario } from "./usuario.model";

export {Carteira}

interface Carteira{
    id: number;
    nomeCarteira: string;
    dinheiro: number;
    id_usuario: Usuario;
    id_banco?: Banco;
}