import { HttpClient, HttpParams } from '@angular/common/http';
import { ErrorHandler } from '../error.handler';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Banco } from '../models/banco.model';

@Injectable({
  providedIn: 'root'
})
export class BancoService {

  constructor(private http: HttpClient) { }

  getListarBanco(): Observable<Banco>{
    return this.http.get<Banco>(environment.UrlApiBanco + `${"/listarBancos"}`).pipe(catchError(ErrorHandler.handleError));
  }
}
