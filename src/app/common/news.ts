import { Domain } from './domain';

export class News {
    id: number;
    url:string;
    title:string;
    date:string;
    content:string;
    domain: Domain;
}
