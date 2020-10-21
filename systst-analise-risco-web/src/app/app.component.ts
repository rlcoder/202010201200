import {Component, OnInit} from '@angular/core';
import {VeiculoService} from './services/veiculo.service';
import {VeiculoModel} from './models/veiculo.model';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'systst-analise-risco-web';
  listaVeiculos: any;
  filtroForm: FormGroup;
  error: any;
  constructor(private veiculoService: VeiculoService) {
  }

  ngOnInit(): void {
    this.filtroForm = new FormGroup({
      selectRisco: new FormControl('TODOS')
    });
  }

  buscarVeiculos(): void {
    this.veiculoService.obterListaVeiculosPorClassificacaoRisco(this.filtroForm.controls.selectRisco.value).subscribe((result) => {
      this.listaVeiculos = result;
    }, (error) => {
      error = 'Falha';
      console.log(error);
    });
  }

  getValorFormatado(valor): string {
    if (valor == null || valor === undefined || valor === '') { return valor; }
    return 'R$ ' + valor.toFixed(2).replace('.', ',').replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1.');
  }

}
