import {Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { langObservable, setLang, getLang } from "@vuce/styleguide";
import {TranslateModule, TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-root-one',
  standalone: true,
  imports: [RouterOutlet, TranslateModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'mf-one';
  private readonly availableLanguages = ['en', 'es'];

  selectLang(name: string) {
    setLang(name);
  }

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
