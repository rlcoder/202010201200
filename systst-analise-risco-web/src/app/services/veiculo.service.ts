import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {VeiculoModel} from '../models/veiculo.model';

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  apiUrl = environment.apiUrl;
  apiUrlVeiculo = this.apiUrl + '/rest/veiculo/';

  constructor(private http: HttpClient) {
  }


  obterListaVeiculosPorClassificacaoRisco(risco: string): Observable<VeiculoModel> {
    return this.http.get(`${this.apiUrlVeiculo}listar/classificacao-risco/${risco}`);
  }
}
