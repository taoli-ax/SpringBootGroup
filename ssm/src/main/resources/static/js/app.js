const app = Vue.createApp({
  data() {
    return {
      tableData: [],
      searchText: {
      name:"",
      brand:""
      },
      cupId:'',
      cupName:'',
      cupBrand:'',
      totalPage:'',
      currentPage:'',
      pageSize:'',
      pageData:[],
      customPageSize:5,
      pageNationElement:""

    }
  },
  methods: {
    search() {
       axios.get(`/cups/${this.searchText.name}/${this.searchText.brand}`).then(response => {
              console.log(response);
              let a=[]
              if(typeof response.data.data==="object" && response.data.data!=null){
                this.tableData=a.push(response.data.data);
                console.log(this.tableData);
              }else{
                this.tableData = response.data.data;
              }
              
              
            })
              },
    getAll() {
      axios.get('/cups').then(response => {
        console.log(response);
        this.tableData = response.data.data
      })
    },
    PageNation(PageNum=1,PageSize=5){
        axios.post(`/cups/pageNation1/${PageNum}/${PageSize}`)
          .then(response=> {
          this.totalPage=response.data.data.pages;
          this.currentPage=response.data.data.pageNum;
          this.pageSize=response.data.data.size;
          this.tableData = response.data.data.list;

          let pageList=response.data.data.navigatepageNums.map(item=>{
              if(this.currentPage==item){
                    return `

                    <li class="page-item active"><a class="page-link" href="#" >${item}</a></li>
                    `
              }
                    return `<li class="page-item"><a class="page-link" href="#" onclick=PageNation(`+`${item}`+`,`+`${this.customPageSize}`+`)>`+`${item}`+`</a></li>`
              }).join("");

          pageList+=``
              $("#pages").html(pageList);
          })
          .catch(function (error) {
            console.log(error);
          });
    },

    Previous(){

        if(this.currentPage==1){
        console.log(this.currentPage)
            return;
        }
        PageNation(this.currentPage-1,this.customPageSize);
    },
    NextPage(){

            if(this.currentPage==this.totalPage){
                return;
            }
            PageNation(this.currentPage+1,this.customPageSize);
    },
    EndPage(){
        if(this.currentPage==this.totalPage){
                        return;
        };
         PageNation(this.totalPage,this.customPageSize);
    },


    editItem(id,name,brand) {
    this.cupId=id;
    this.cupName=name;
    this.cupBrand=brand;
    $("#exampleModalLabel").text("修改");
    },
    async updateItem(){
         await axios.put(`/cups`,{
            id:this.cupId,
            name:this.cupName,
            brand:this.cupBrand
         }).
         then(function (response) {
            console.log(response.data.data);
                 }).catch(function (error) {
                 console.log(error);
                 });


    },
    deleteItem(id) {
        axios.delete(`/cups/${id}`).
        then(function (response) {
                console.log(response);
                }).catch(function (error) {
                console.log(error);
                });
          // Delete item logic
    },
    openModal(){
    $("#exampleModalLabel").text("新增");
     this.cupId='';
     this.cupName='';
     this.cupBrand='';
    },
    addItem(Cup) {


         axios.post('/cups', {
             name: this.cupName,
             brand: this.cupBrand
           })
           .then(function (response) {
             console.log(response);
           })
           .catch(function (error) {
             console.log(error);
           });
        // Delete item logic
}
  },
  created(){
   this.PageNation()
  },
  mounted() {
//    this.getAll()
window.PageNation=this.PageNation;
window.Previous=this.Previous;
window.NextPage=this.NextPage;
window.EndPage=this.EndPage;

  }
})