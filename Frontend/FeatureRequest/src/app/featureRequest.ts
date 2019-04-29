import { Client } from './client';
import { ProductArea } from './productArea';

export class FeatureRequest{
    requestID: number;
    title: string;
    description: string;
    client: Client;
    priority: number;
    targetDate: Date;
    productArea: ProductArea;
    createTimestamp: Date;
}