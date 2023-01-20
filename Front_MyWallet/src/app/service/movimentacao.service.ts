import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { __param } from 'tslib';
import { ErrorHandler } from '../error.handler';
import { Movi } from '../models/movimentacao.model';

@Injectable({
  providedIn: 'root'
})
export class MovimentacaoService {

  constructor(private http: HttpClient) { }

  postRealizarTransacao(movimentacao: Movi): Observable<Movi>{
    return this.http.post<Movi>(environment.UrlApiMovimentacao + `${"/realizarTransacao"}`, movimentacao).pipe(catchError(ErrorHandler.handleError)); 
  }

  getListarSaques(idConta: number, idTipo: number): Observable<Movi[]>{
    return this.http.get<Movi[]>(environment.UrlApiMovimentacao + `${"/listarSaques"}`, {params: new HttpParams().set("idConta", idConta).set("idTipo", idTipo)}).pipe(catchError(ErrorHandler.handleError));
  }

  getListarDepositos(idConta: number, idTipo: number): Observable<Movi[]>{
    return this.http.get<Movi[]>(environment.UrlApiMovimentacao + `${"/listarDepositos"}`, {params: new HttpParams().set("idConta", idConta).set("idTipo", idTipo)}).pipe(catchError(ErrorHandler.handleError));
  }

  getListarMovimentacao(idMovimentacao: number): Observable<Movi[]>{
    return this.http.get<Movi[]>(environment.UrlApiMovimentacao + `${"/listarMovimentacao"}`, {params: new HttpParams().set("idConta", idMovimentacao)}).pipe(catchError(ErrorHandler.handleError));
  }

  postRealizarTransacaoCarteira(movimentacao: Movi): Observable<Movi>{
    return this.http.post<Movi>(environment.UrlApiMovimentacao + `${"/realizarTransacaoCarteira"}`, movimentacao).pipe(catchError(ErrorHandler.handleError)); 
  }
}