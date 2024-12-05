let fetchedData = null;

(async function fetchAndSaveJson() {
    const url = 'https://ddragon.leagueoflegends.com/cdn/14.23.1/data/en_US/summoner.json';

    try {
        const response = await fetch(url);

        if (!response.ok) {
            throw new Error('데이터 요청 실패');
        }

        fetchedData = await response.json();
    } catch (error) {
        console.error('데이터를 가져오는 도중 에러가 발생했습니다:', error);
    }
})();

function getIdByKey(key) {
    if (!fetchedData) {
        console.error('데이터가 아직 로드되지 않았습니다.');
    }

    for (const spell in fetchedData.data) {
        if (fetchedData.data[spell].key === key) {
            return fetchedData.data[spell].id;
        }
    }
    console.error('데이터가 찾을수 없습니다.');
}

