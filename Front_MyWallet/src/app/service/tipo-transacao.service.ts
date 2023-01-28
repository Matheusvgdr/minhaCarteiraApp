import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ErrorHandler } from '../error.handler';
import { TT } from '../models/tipoTransacao.mode';

@Injectable({
  providedIn: 'root'
})
export class TipoTransacaoService {

  constructor(private http: HttpClient) { }

  getListarTipos(): Observable<TT[]>{
    return this.http.get<TT[]>(environment.UrlApiTipoTransacao + `${"/listarTipoTransacao"}`).pipe(catchError(ErrorHandler.handleError));
  }
}