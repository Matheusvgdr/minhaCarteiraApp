import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ErrorHandler } from '../error.handler';
import { TipoTransacao } from '../models/tipoTransacao.mode';

@Injectable({
  providedIn: 'root'
})
export class TipoTransacaoService {

  constructor(private http: HttpClient) { }

  getListarTipos(idTipoTransacao: number): Observable<TipoTransacao[]>{
    return this.http.get<TipoTransacao[]>(environment.UrlApiUsuario + `${"/listarTipos"}`, {params: new HttpParams().set("idTipoTransacao", idTipoTransacao)}).pipe(catchError(ErrorHandler.handleError));
  }
}
