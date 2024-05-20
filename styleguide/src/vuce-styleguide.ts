import { Subject } from "rxjs";

export const langObservable = new Subject<string>();

export const setLang = (name: string) => {
  localStorage.setItem("lang", name);
  langObservable.next(name);
};

export const getLang = () => {
  return localStorage.getItem("lang") ?? "es";
};

langObservable.next(getLang());
