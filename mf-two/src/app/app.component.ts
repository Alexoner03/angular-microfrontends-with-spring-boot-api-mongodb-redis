import {Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {getLang, langObservable} from "@vuce/styleguide";
import {TranslateModule, TranslateService} from "@ngx-translate/core";
import {forkJoin} from "rxjs";

export interface ILanguageOption {
  value: string;
  label: string;
}

@Component({
  selector: 'app-root-two',
  standalone: true,
  imports: [RouterOutlet, TranslateModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'mf-two';
  private readonly availableLanguages = ['en', 'es'];

  constructor(private readonly translate: TranslateService) {
    this.translate.addLangs(this.availableLanguages);
    const lang = getLang();
    this.translate.setDefaultLang(lang)
    this.changeLanguage(lang)

    langObservable.subscribe((lang) => {
      this.changeLanguage(lang)
    });
  }

  changeLanguage(lang: string) {
    this.translate.use(lang);
  }
}
