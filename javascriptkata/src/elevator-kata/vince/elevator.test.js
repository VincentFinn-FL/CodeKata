let elevator = {
    getFloor: function () {
        return 0;
    }
}
describe('elevator', function () {
    it('should return floor 0', function () {
        expect(elevator.getFloor()).toEqual(0)
    });
});