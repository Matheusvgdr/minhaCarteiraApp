import { Usuario } from "./usuario.model";

export {Cartao}

interface Cartao{
    id: number;
    banco: string;
    id_usuario?: Usuario;
}