import { Injectable } from '@angular/core';

@Injectable()
export class ConfigModeServerService {
    // ipServer:string="http://103.208.24.217:8080"; //production mode
    ipServer:string="http://localhost:8080"; //develop mode
  constructor() { }

}
