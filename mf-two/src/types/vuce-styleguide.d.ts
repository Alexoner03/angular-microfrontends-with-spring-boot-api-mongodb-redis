declare module '@vuce/styleguide' {
  import { Subject } from "rxjs";
  export declare const langObservable: Subject<string>;
  export declare const setLang: (name: string) => void;
  export declare const getLang: () => string;
}
