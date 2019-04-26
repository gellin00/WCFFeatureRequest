export class FeatureRequest{
    requestID: number;
    title: string;
    description: string;
    Client: {
        clientID: number;
        clientName: string;
    };
    priority: number;
    targetDate: Date;
    ProductArea: {
        areaID: number;
        areaName: string;
    };
    rowStatus: string;
    createTimestamp: Date;
}